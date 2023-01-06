import java.util.ArrayList;
import java.util.List;

public final class ImmutableDemo {
    private String name;
    private int age ;
    private List<String> address;

    public ImmutableDemo(String name, int age, List<String> addresses) {
        this.name = name;
        this.age = age;
        this.address = new ArrayList<>();
        for (String address : addresses){
            this.address.add(address);
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getAddress() {
      List<String> addressList = new ArrayList<>();
      for(String add : address){
          addressList.add(add);
      }
        return addressList;
    }

    @Override
    public String toString() {
        return "ImmutableDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
