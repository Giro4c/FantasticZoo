package Colony;

import java.util.ArrayList;


public final class ColonyMaster {
    private String name;
    private boolean isMale;
    private int age;

    public ColonyMaster (String name, boolean isMale, int age) {
        this.name = name;
        this.isMale = isMale;
        this.age = age;
    }

    public void examineTerritory(Territory territory) {
        System.out.println(territory);
    }


    
    public String getName() {
        return this.name;
    }

    public boolean getIsMale() {
        return this.isMale;
    }

    public int getAge() {
        return this.age;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }

    public void setSex(boolean isMale) {
        this.isMale = isMale;
    }

    public void setAge(int age) {
        this.age = age;
    }
}