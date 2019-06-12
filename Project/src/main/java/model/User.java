package model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String email;
    private int password;
    private String nickName;
    private String name;
    private Object picture;

    public User(){}

    public User(String email, int password, String nickName, String name, Object picture) {
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.name = name;
        this.picture = picture;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[email=%d, password='%d', nickname='%s']",
                email, password, nickName);
    }
}
