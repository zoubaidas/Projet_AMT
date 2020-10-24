package io.zoubaidas.overflowstack.domain.user;


import io.zoubaidas.overflowstack.domain.IEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Builder(toBuilder = true)
public class User implements IEntity<User, UserId> {
    private UserId id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;

    @EqualsAndHashCode.Exclude
    private String encryptedPwd;

    public boolean authenticate(String clearPwd) {
        //TODO Add encryption !
        return clearPwd.equals(encryptedPwd);
    }

    @Override
    public User deepClone() {
        return this.toBuilder()
                .id(new UserId(id.asString()))
                .build();
    }

    public static class UserBuilder {
        public UserBuilder clearPwd(String clearPwd){
            if(clearPwd == null || clearPwd.isEmpty()) {
                throw new IllegalArgumentException("Password is mandatory");
            }

            //TODO add encryption!
            encryptedPwd = clearPwd;
            return this;
        }

        public User build() {
            if(id == null) {
                id = new UserId();
            }

            if(username == null || username.isEmpty()) {
                throw new java.lang.IllegalArgumentException("Username is mandatory");
            }
            if(encryptedPwd == null || encryptedPwd.isEmpty()) {
                throw new java.lang.IllegalArgumentException("Password is mandatory");
            }
            if(firstName == null || firstName.isEmpty()) {
                throw new java.lang.IllegalArgumentException("First name is mandatory");
            }
            if(lastName == null || lastName.isEmpty()) {
                throw new java.lang.IllegalArgumentException("Last name is mandatory");
            }
            if(email == null || email.isEmpty()) {
                throw new java.lang.IllegalArgumentException("Email is mandatory");
            }

            User newUser = new User(id, username, email, firstName, lastName, encryptedPwd);
            return newUser;
        }
    }
}
