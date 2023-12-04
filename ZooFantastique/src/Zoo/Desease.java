package Zoo;

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
    public Thread deseaseThread;
    public Desease(String name, int damage, int severity, int time, Creature animal) {
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
        deseaseAct();
    }
    public void deseaseAct() {
        final int[] currentTime = {0};
        deseaseThread = new Thread(() -> {
            while (currentTime[0] <= getTime() && !isTreated && !Thread.currentThread().isInterrupted()) {
                try {
                    getAnimal().becomeMoreSick();

                    // Handle interruption when sleeping
                    Thread.sleep(15000 / severity);

                    if (canBeTreatedAlone) {
                        synchronized (currentTime) {
                            currentTime[0] += 1;
                            System.out.println(animal.getName() + " est malade depuis " + currentTime[0] + " secondes");
                        }
                    }
                } catch (InterruptedException e) {
                    // Restore interrupted status and exit the loop
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            destroyDesease();
        });
        deseaseThread.start();
    }



    private void destroyDesease() {
        if (this.animal != null) {
            this.animal.setIsSick(false);
            System.out.println(this.animal.isSick);
            this.animal.setDesease(null);
        }
        this.isTreated = true;  // Set isTreated to true to avoid repeated destruction
        this.name = null;
        this.animal = null;
    }


    public String getName() {
        return name;
    }
    public void remove(Creature creature) {
        if (this.canBeTreatedWithMedecine== true&& !isTreated) {
            new Thread(() -> {
                isTreated = true;
                deseaseThread.interrupt(); // Interrupt the deseaseThread
            }).start();
        } else {
            System.err.println("L'animal " + this.animal.getName() + " a une maladie incurable...");
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
