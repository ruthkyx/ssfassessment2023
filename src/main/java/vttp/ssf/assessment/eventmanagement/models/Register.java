package vttp.ssf.assessment.eventmanagement.models;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Register {
    
    @NotBlank(message="Field is required")
    @Size(min=5, max=25, message="Min 5 characters & max 25 characters")
    private String fullName;

    @NotBlank(message="Field is required")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Past
    private String dob;

    @NotBlank(message="Field is required")
    @Email
    private String email;

    @Pattern(regexp="(8|9)[0-9]{7}")
    private String phone;

    private String gender;

    @Size(min=1, max=3)
    private String qty; // number of tickets requested
}
