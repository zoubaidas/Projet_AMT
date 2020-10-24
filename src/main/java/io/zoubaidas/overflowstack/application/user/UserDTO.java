package io.zoubaidas.overflowstack.application.user;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
}
