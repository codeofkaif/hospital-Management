package hospitalManagement.hospitalManagementAPI.dto;

import hospitalManagement.hospitalManagementAPI.entity.Type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodGroupCountDto {
    private BloodGroupType bloodGroupType;
    private Long count;


}
