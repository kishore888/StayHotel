package com.hospitality.employee.boimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.core.FormFieldConfig;
import com.hospitality.core.Hotel;
import com.hospitality.dao.FormFieldConfigDAO;
import com.hospitality.employee.bo.FormFieldConfigBO;

@Service("FormFieldConfigBO")
@Scope(value = "prototype")
public class FormFieldConfigBOImpl implements FormFieldConfigBO {

    @Autowired
    private FormFieldConfigDAO formFieldConfigDAO;

    @Override
    public List<FormFieldConfig> getByHotelAndEntity(String hotelId, String entityType) throws Exception {
        return formFieldConfigDAO.findByHotelAndEntity(hotelId, entityType);
    }

    @Override
    public List<FormFieldConfig> getDefaultConfig(String entityType) throws Exception {
        if ("employee".equalsIgnoreCase(entityType)) {
            return buildEmployeeDefaults();
        }
        return new ArrayList<>();
    }

    @Override
    public void saveAll(List<FormFieldConfig> configs) throws Exception {
        for (FormFieldConfig config : configs) {
            if (config.getConfigId() != null && !config.getConfigId().isEmpty()) {
                formFieldConfigDAO.update(config);
            } else {
                formFieldConfigDAO.create(config);
            }
        }
    }

    private List<FormFieldConfig> buildEmployeeDefaults() {
        List<Object[]> defs = Arrays.asList(
            new Object[]{"prefix",                 "Prefix",                  "select",   false, false, 1,  null, null, null, "Mr.,Mrs.,Ms.,Dr.,Prof."},
            new Object[]{"firstName",              "First Name",              "text",     true,  true,  2,  100,  null, null, null},
            new Object[]{"lastName",               "Last Name",               "text",     true,  true,  3,  100,  null, null, null},
            new Object[]{"gender",                 "Gender",                  "select",   true,  false, 4,  null, null, null, "Male,Female,Other"},
            new Object[]{"emailId",                "Email",                   "text",     true,  false, 5,  200,  "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", "Enter a valid email", null},
            new Object[]{"phone",                  "Phone",                   "text",     true,  false, 6,  15,   "^[0-9+\\-\\s]{7,15}$", "Enter a valid phone number", null},
            new Object[]{"role",                   "Role",                    "select",   true,  true,  7,  null, null, null, "ADMIN,MANAGER,RECEPTIONIST,HOUSEKEEPING,MAINTENANCE,RESTAURANT,SECURITY"},
            new Object[]{"department",             "Department",              "select",   true,  false, 8,  null, null, null, "FRONT_DESK,HOUSEKEEPING,FOOD_BEVERAGE,MAINTENANCE,SECURITY,ADMINISTRATION"},
            new Object[]{"salary",                 "Salary (₹)",              "number",   true,  false, 9,  null, null, null, null},
            new Object[]{"joiningDate",            "Joining Date",            "date",     true,  false, 10, null, null, null, null},
            new Object[]{"status",                 "Status",                  "select",   true,  false, 11, null, null, null, "ACTIVE,INACTIVE,ON_LEAVE"},
            new Object[]{"qualification",          "Qualification",           "text",     false, false, 12, 200,  null, null, null},
            new Object[]{"religion",               "Religion",                "select",   false, false, 13, null, null, null, "Hindu,Muslim,Christian,Sikh,Buddhist,Jain,Other"},
            new Object[]{"maritalStatus",          "Marital Status",          "checkbox", false, false, 14, null, null, null, null},
            new Object[]{"fatherName",             "Father Name",             "text",     false, false, 15, 200,  null, null, null},
            new Object[]{"panNumber",              "PAN Number",              "text",     false, false, 16, 10,   "^[A-Z]{5}[0-9]{4}[A-Z]{1}$", "Enter a valid PAN", null},
            new Object[]{"audharCardNo",           "Aadhaar Card No",         "text",     false, false, 17, 12,   "^[0-9]{12}$", "Enter 12-digit Aadhaar", null},
            new Object[]{"passportNo",             "Passport No",             "text",     false, false, 18, 20,   null, null, null},
            new Object[]{"drivingLicenceNo",       "Driving Licence No",      "text",     false, false, 19, 20,   null, null, null},
            new Object[]{"voterId",                "Voter ID",                "text",     false, false, 20, 20,   null, null, null},
            new Object[]{"permanentAddress",       "Permanent Address",       "text",     false, false, 21, 500,  null, null, null},
            new Object[]{"correspondenceAddress",  "Correspondence Address",  "text",     false, false, 22, 500,  null, null, null}
        );

        List<FormFieldConfig> list = new ArrayList<>();
        for (Object[] d : defs) {
            FormFieldConfig f = new FormFieldConfig();
            f.setFieldName((String) d[0]);
            f.setLabel((String) d[1]);
            f.setFieldType((String) d[2]);
            f.setVisible((Boolean) d[3]);
            f.setRequired((Boolean) d[4]);
            f.setFieldOrder((Integer) d[5]);
            f.setMaxLength((Integer) d[6]);
            f.setPatternRegex((String) d[7]);
            f.setPatternMessage((String) d[8]);
            f.setFieldOptions((String) d[9]);
            f.setEntityType("employee");
            list.add(f);
        }
        return list;
    }
}
