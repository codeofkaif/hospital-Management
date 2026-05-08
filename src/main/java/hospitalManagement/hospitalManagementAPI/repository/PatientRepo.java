package hospitalManagement.hospitalManagementAPI.repository;

import hospitalManagement.hospitalManagementAPI.dto.BloodGroupCountDto;
import hospitalManagement.hospitalManagementAPI.entity.Patient;
import hospitalManagement.hospitalManagementAPI.entity.Type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository

public interface PatientRepo extends JpaRepository<Patient, Long> {
    Patient findByName(String name);

    List<Patient> findByBirthdayOrEmail(LocalDate birthday, String mail);
    List<Patient> findByBirthdayBetween(LocalDate birthday1 , LocalDate birthday2);

    @Query("SELECT p FROM Patient p where p.bloodGroup=?1")
    List<Patient> findByBloodGroup( BloodGroupType bloodGroup);
    @Query("SELECT p FROM Patient p where p.birthday > :birthday" )
    List<Patient> findByBornAfterDate(@Param("birthday") LocalDate birthday );
    @Query("select new hospitalManagement.hospitalManagementAPI.dto.BloodGroupCountDto( p.bloodGroup,count(p)) from Patient p group by p.bloodGroup")
//    List<Object[]> countEachBloodGroupType();
    List<BloodGroupCountDto> countEachBloodGroupType();
    @Query(value ="select * from Patient" , nativeQuery = true)
    Page<Patient> findAllpatients(Pageable pageable);
    @Transactional
    @Modifying
    @Query("Update Patient p SET p.name =:name where p.id=:id")
    int updateNameWithId(@Param("name") String name ,@Param("id") Long id);

}
