package tk.dadle8.web.services.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Country {
    private int id;
    private String name;
    private String fullname;
    private int population;
    private String capital;

    @Override
    public String toString() {
        return "Country{" + "id=" + id + ", name=" + name + ", fullname=" + fullname + ", population=" + population + ", capital=" + capital + '}';
    }
}
