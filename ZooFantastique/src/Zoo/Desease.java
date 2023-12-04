package ZooFantastique.src.Zoo;
import Zoo.Animals.Creature;
public class Desease {
    public static final String[] HUNGER_STATES = {"Full", "Normal", "Hungry", "Famished", "Dead"};
    private String name;
    private int damage;
    private int time;
    private int severity;
    private boolean canBeTreatedAlone;
    private boolean canBeTreatedWithMedecine;
    private Creature animal;
    private boolean isTreated = false;
    private Desease(String name, int damage, int severity, int time, Creature animal) {
        this.name = name;
        this.damage = damage;
        this.severity = severity;
        this.time = time;
        this.animal = animal;
        animal.setDesease(this);
        if (severity == 3) {
            canBeTreatedAlone = false;
            canBeTreatedWithMedecine = false;
        }
        if (severity == 2) {
            canBeTreatedAlone = false;
            canBeTreatedWithMedecine = true;
        } else {
            canBeTreatedAlone = true;
            canBeTreatedWithMedecine = true;
        }
    }
    public void deseaseAct(){
        final int[] currentTime = {0};
        Thread deseaseThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                while (currentTime[0] <=getTime()) {
                    try {
                        synchronized (currentTime){
                            Thread.sleep(15000/severity);
                            getAnimal().becomeMoreSick();
                            if (canBeTreatedAlone){currentTime[0]+=1;}
                            if (isTreated){break;}
                            System.out.println(getName()+" est malade depuis "+ currentTime[0] + " secondes");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                destroyDesease();
                }
            }
        });
        deseaseThread.start();
    }
    private void destroyDesease() {
        this.name = null;
        this.animal.setDesease(null);
        this.animal = null;
    }
    public String getName() {
        return name;
    }
    public void remove(Creature creature){
        if (this.severity!=3){
            isTreated = true;
        }
        else {
            System.err.println("L'animal " + this.animal.getName()+" à une maladie incurable...");
        }
    }
    public int getDamage() {
        return damage;
    }

    public int getSeverity() {
        return severity;
    }

    public Creature getAnimal() {
        return animal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public void setAnimal(Creature animal) {
        this.animal = animal;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
