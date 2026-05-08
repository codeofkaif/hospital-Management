package hospitalManagement.hospitalManagementAPI.services;

import hospitalManagement.hospitalManagementAPI.entity.Patient;
import hospitalManagement.hospitalManagementAPI.repository.PatientRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientServiceImp implements PatientServices {
    private final PatientRepo patientRepo;
    private final ModelMapper modelMapper;

    public Patient getPatientById(Long id){
        Patient p1 = patientRepo.findById(id).orElseThrow();
        Patient p2 = patientRepo.findById(id).orElseThrow();
        return p1;

    }

}
