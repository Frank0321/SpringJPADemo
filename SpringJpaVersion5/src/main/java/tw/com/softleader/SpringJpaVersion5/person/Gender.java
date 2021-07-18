package tw.com.softleader.SpringJpaVersion5.person;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Gender {
    man(1, "男"),
    woman(0, "女");

    private int code;
    private String name;

}
