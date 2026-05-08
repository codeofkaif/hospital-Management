package hospitalManagement.hospitalManagementAPI;

import hospitalManagement.hospitalManagementAPI.entity.Patient;
import hospitalManagement.hospitalManagementAPI.repository.PatientRepo;
import hospitalManagement.hospitalManagementAPI.services.PatientServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootTest
public class patientTest {
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private PatientServices services;


    @Test
    public void testPatientRepository(){
        List<Patient> PatientList= patientRepo.findAll();
        System.out.println(PatientList);
    }

    @Test
    public void testPatientTransection(){
//        Patient patient = services.getPatientById(1L);
//        System.out.println(patient);
//        Patient patient = patientRepo.findByName("Kabir Singh");
//        System.out.println(patient);
//         List<Patient> patientList = patientRepo.findByBirthdayBetween(LocalDate.of(1980 , 5 , 10) , LocalDate.of(1990 , 7,11));
//        List<Patient> patientList = patientRepo.findByBloodGroup(BloodGroupType.A_POSITIVE);
//        List<Patient> patientList = patientRepo.findByBornAfterDate(LocalDate.of(1993 ,5 ,10));
        Page<Patient> patientList = patientRepo.findAllpatients(PageRequest.of(2 ,2));
        for(Patient patient:patientList){
            System.out.println(patient);

        }
//        List<BloodGroupCountDto> bloodGroupDtoList = patientRepo.countEachBloodGroupType();
//        for(BloodGroupCountDto bloodGroupCountDtoObject:bloodGroupDtoList){
//            System.out.println(bloodGroupCountDtoObject);
//        }
//        int updateValue =patientRepo.updateNameWithId("kaif khan" ,5L);
//        System.out.println(updateValue);


    }


}
