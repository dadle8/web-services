package tk.dadle8.web.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    private int id;
    private String name;
    private String fullname;
    private int population;
    private String capital;

    @Override
    public String toString() {
        return "Country{" + "id=" + id + ", name=" + name + ", fullname=" + fullname + ", population=" + population + ", capital" + capital + '}';
    }
}
