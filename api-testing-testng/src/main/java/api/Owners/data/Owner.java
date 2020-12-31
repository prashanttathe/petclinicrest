package api.Owners.data;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Owner {

    @Expose
    private String id;

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private String address;

    @Expose
    private String city;

    @Expose
    private String telephone;

    @Expose
    private List<Pet> pets;

}
