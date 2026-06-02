# Java 25 Upgrade Plan for StayHotel Application

## Executive Summary

This document outlines the step-by-step plan to upgrade the StayHotel application from **Java 17** to **Java 25**. The upgrade involves updating system Java, Gradle configuration, and all module build files.

**Current State:**
- Java Version: 17
- Spring Boot: 4.0.1
- Spring Cloud: 2025.1.1
- Gradle: 8.14
- Modules: 8 (common-repository, common-utils, RoomBooking, Employee, Admin, Payment, API-Gateway-HTM, EurekaServer, KPIChatbot)

**Target State:**
- Java Version: 25
- Spring Boot: 4.0.1 (no change)
- Spring Cloud: 2025.1.1 (no change)
- Gradle: 8.14 (no change, already supports Java 25)

**Estimated Time:** 2-3 hours
**Risk Level:** Medium (Spring Boot 4.0.1 and Spring Cloud 2025.1.1 support Java 25)

---

## Pre-Upgrade Checklist

### 1. System Prerequisites
- [ ] Verify current Java version: `java -version` (should be 17)
- [ ] Verify Gradle version: `./gradlew --version` (should be 8.14)
- [ ] Ensure all services are currently stopped
- [ ] Backup current working state (git commit or branch)
- [ ] Document current running configurations (ports, environment variables)

### 2. Compatibility Research
- [ ] Spring Boot 4.0.1 supports Java 25 ✓ (released 2025, Java 25 released Sept 2025)
- [ ] Spring Cloud 2025.1.1 supports Java 25 ✓
- [ ] Gradle 8.14 supports Java 25 ✓
- [ ] MySQL Connector/J supports Java 25 ✓
- [ ] Lombok supports Java 25 ✓
- [ ] Jackson supports Java 25 ✓
- [ ] Keycloak Admin Client supports Java 25 ✓

---

## Step-by-Step Upgrade Procedure

### Phase 1: System Java Installation

#### Step 1.1: Install Java 25 on macOS
```bash
# Using Homebrew (recommended)
brew install openjdk@25

# Or download from Oracle/Adoptium and install manually
```

#### Step 1.2: Set JAVA_HOME
```bash
# Add to ~/.zshrc or ~/.bash_profile
export JAVA_HOME=$(/usr/libexec/java_home -v 25)
export PATH=$JAVA_HOME/bin:$PATH

# Reload shell
source ~/.zshrc
```

#### Step 1.3: Verify Installation
```bash
java -version
# Should output: openjdk version "25.x.x"
```

---

### Phase 2: Gradle Configuration Updates

#### Step 2.1: Update Root build.gradle
**File:** `/Users/kishore/Documents/Projects/StayHotel/build.gradle`

**Change:**
```gradle
java {
    sourceCompatibility = '17'
}
```
**To:**
```gradle
java {
    sourceCompatibility = '25'
}
```

#### Step 2.2: Update Module build.gradle Files

**Files to update (8 files):**
1. `/Users/kishore/Documents/Projects/StayHotel/common-repository/build.gradle`
2. `/Users/kishore/Documents/Projects/StayHotel/common-utils/build.gradle`
3. `/Users/kishore/Documents/Projects/StayHotel/RoomBooking/build.gradle`
4. `/Users/kishore/Documents/Projects/StayHotel/Employee/build.gradle`
5. `/Users/kishore/Documents/Projects/StayHotel/Admin/build.gradle`
6. `/Users/kishore/Documents/Projects/StayHotel/Payment/build.gradle`
7. `/Users/kishore/Documents/Projects/StayHotel/API-Gateway-HTM/build.gradle`
8. `/Users/kishore/Documents/Projects/StayHotel/EurekaServer/build.gradle`
9. `/Users/kishore/Documents/Projects/StayHotel/KPIChatbot/build.gradle`

**Pattern 1: For modules using `sourceCompatibility`:**
```gradle
java {
    sourceCompatibility = '17'
}
```
**Change to:**
```gradle
java {
    sourceCompatibility = '25'
}
```

**Pattern 2: For modules using `toolchain`:**
```gradle
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}
```
**Change to:**
```gradle
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}
```

**Affected modules with toolchain:**
- common-repository
- common-utils
- KPIChatbot
- API-Gateway-HTM

**Affected modules with sourceCompatibility:**
- RoomBooking
- Employee
- Admin
- Payment
- EurekaServer
- Root build.gradle

---

### Phase 3: Dependency Verification

#### Step 3.1: Update Lombok Version (if needed)
Lombok 1.18.32 (currently used) supports Java 25. No change needed.

#### Step 3.2: Verify Other Dependencies
Run dependency check to ensure all libraries are compatible:
```bash
./gradlew dependencies
```

---

### Phase 4: Build and Compilation

#### Step 4.1: Clean Build
```bash
./gradlew clean
```

#### Step 4.2: Compile All Modules
```bash
./gradlew compileJava
```

**Expected Output:** BUILD SUCCESSFUL

**If compilation fails:**
- Note the error message
- Check if any dependency needs update
- Refer to troubleshooting section below

#### Step 4.3: Full Build
```bash
./gradlew build -x test
```

---

### Phase 5: Testing

#### Step 5.1: Run Unit Tests
```bash
./gradlew test
```

#### Step 5.2: Start Services in Order
1. **EurekaServer** (port 8761)
   ```bash
   cd EurekaServer
   ../gradlew bootRun
   ```

2. **common-repository** (if standalone, with profile)
   ```bash
   cd common-repository
   ../gradlew bootRun -Dspring.profiles.active=standalone
   ```

3. **API-Gateway-HTM** (port 8880)
   ```bash
   cd API-Gateway-HTM
   ../gradlew bootRun
   ```

4. **RoomBooking** (port 8882)
   ```bash
   cd RoomBooking
   ../gradlew bootRun
   ```

5. **Employee** (port 8883)
   ```bash
   cd Employee
   ../gradlew bootRun
   ```

6. **Admin** (port 8884)
   ```bash
   cd Admin
   ../gradlew bootRun
   ```

7. **Payment** (port 8885)
   ```bash
   cd Payment
   ../gradlew bootRun
   ```

8. **KPIChatbot** (port 8886)
   ```bash
   cd KPIChatbot
   ../gradlew bootRun
   ```

#### Step 5.3: Functional Testing
- [ ] Verify Eureka dashboard shows all registered services
- [ ] Test API Gateway routing
- [ ] Test RoomBooking endpoints
- [ ] Test Employee endpoints
- [ ] Test Admin endpoints
- [ ] Test Payment endpoints
- [ ] Test KPIChatbot endpoints
- [ ] Verify JWT authentication works
- [ ] Verify database connectivity

---

### Phase 6: IDE Configuration

#### Step 6.1: Update IDE Java Version
**IntelliJ IDEA:**
1. File → Project Structure → Project
2. Set SDK to Java 25
3. Set Language Level to 25

**Eclipse/STS4:**
1. Window → Preferences → Java → Installed JREs
2. Add Java 25
3. Right-click project → Properties → Java Build Path
4. Set JRE to Java 25

#### Step 6.2: Refresh Gradle Project
- In IDE, refresh Gradle project to pick up new configuration

---

## Rollback Plan

If the upgrade fails, rollback procedure:

### Option 1: Git Rollback (Recommended)
```bash
# Commit changes before upgrade
git add .
git commit -m "Pre-upgrade state: Java 17"

# If upgrade fails
git reset --hard HEAD~1
```

### Option 2: Manual Rollback
1. Revert all build.gradle files to Java 17
2. Switch JAVA_HOME back to Java 17
3. Clean and rebuild: `./gradlew clean build`

---

## Known Issues and Considerations

### 1. Lombok Annotation Processing
- Lombok 1.18.32 supports Java 25
- If annotation processor errors occur, update to latest Lombok

### 2. Hibernate 7 Compatibility
- Hibernate 7 (used with Spring Boot 4.0) supports Java 25
- No changes needed to Hibernate configuration

### 3. MySQL Connector
- MySQL Connector J supports Java 25
- No changes needed

### 4. Keycloak Client
- Keycloak Admin Client 22.0.5 supports Java 25
- No changes needed

### 5. Spring AI (KPIChatbot)
- Spring AI 1.0.3 supports Java 25
- No changes needed

---

## Post-Upgrade Verification Checklist

- [ ] All modules compile successfully
- [ ] All unit tests pass
- [ ] All services start without errors
- [ ] Eureka registration works
- [ ] API Gateway routing works
- [ ] Database connectivity works
- [ ] JWT authentication works
- [ ] Angular frontend can access all APIs
- [ ] No performance degradation
- [ ] No memory leaks

---

## Estimated Timeline

| Phase | Duration |
|-------|----------|
| Phase 1: System Java Installation | 15 minutes |
| Phase 2: Gradle Configuration Updates | 30 minutes |
| Phase 3: Dependency Verification | 15 minutes |
| Phase 4: Build and Compilation | 20 minutes |
| Phase 5: Testing | 60-90 minutes |
| Phase 6: IDE Configuration | 15 minutes |
| **Total** | **2.5-3 hours** |

---

## Approval Required

Please review this plan and approve before proceeding with the upgrade.

**Approver:** _________________
**Date:** _________________
**Comments:** _________________

---

## Contact Information

If issues arise during upgrade:
- Spring Boot 4.0.1 Documentation: https://docs.spring.io/spring-boot/docs/4.0.1/reference/html/
- Java 25 Release Notes: https://openjdk.org/projects/jdk/25/
- Gradle 8.14 Documentation: https://docs.gradle.org/8.14/userguide/userguide.html
