package hospitalManagement.hospitalManagementAPI.services;

import hospitalManagement.hospitalManagementAPI.entity.Patient;

public interface PatientServices {

    Patient getPatientById(Long id);
}
