package hu.nye.webapp.books.dto;

import javax.validation.constraints.NotEmpty;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class UserDTO {

    @NotEmpty
    private Long id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String billingName;
    @NotEmpty
    private int postcode;
    @NotEmpty
    private String city;
    @NotEmpty
    private String street;
    @NotEmpty
    private int houseNumber;
    private String floorDoorNumber;
}
