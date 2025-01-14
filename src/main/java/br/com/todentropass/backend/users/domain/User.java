package br.com.todentropass.backend.users.domain;

import br.com.todentropass.backend.users.dto.CreateUserDto;
import br.com.todentropass.backend.users.dto.GetUserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Email
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public GetUserDto toDto() {
        return new GetUserDto(id, name, email, role.name());
    }

    public User toModel(CreateUserDto userDto) {
        return new User(null, userDto.name(), userDto.email(), userDto.password(), UserRole.USER);
    }

}
