package Zoo;

import Zoo.Animals.Creature;

public class Desease {
    private String name;
    private int damage;
    private int time;
    private int severity;
    public boolean canBeTreatedAlone;
    public boolean canBeTreatedWithMedecine;
    private Creature animal;
    private boolean isTreated = false;
    public Thread deseaseThread;
    /**
     * Initializes a new instance of the Desease class.
     * @param name The name of the disease.
     * @param damage The damage caused by the disease.
     * @param severity The severity level of the disease.
     * @param time The time duration of the disease.
     * @param animal The animal affected by the disease.
     */
    public Desease(int damage, int severity, int time, Creature animal) {
        this.name = "a implementer";
        this.damage = damage;
        this.severity = severity;
        this.time = time;
        this.animal = animal;
        animal.becomeSick(this);
        if (severity == 3) {
            canBeTreatedAlone = false;
            canBeTreatedWithMedecine = false;
        }
        if (severity == 2) {
            canBeTreatedAlone = false;
            canBeTreatedWithMedecine = true;
        } 
        if (severity ==1){
            canBeTreatedAlone = true;
            canBeTreatedWithMedecine = true;
        }
        deseaseAct();
    }
    /**
     * Causes the disease to act on the animal.
     * - Severity 3 is incurable and leads to death.
     * - Severity 2 can be treated with medicine.
     * - Severity 1 heals on its own.
     */
    public void deseaseAct() {
        final int[] currentTime = {0};
        deseaseThread = new Thread(() -> {
            while (!isTreated && !Thread.currentThread().isInterrupted()&& this.animal.getIndicatorHealth()!="Dead") {
                try {
                	currentTime[0] += 1;
                	if(canBeTreatedAlone&&currentTime[0]==this.time) {break;}
                	getAnimal().becomeMoreSick();
                    Thread.sleep(1500 / severity);
                    System.out.println(animal.getName() + " est malade depuis " + (currentTime[0]) + " secondes");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            destroyDesease();
        });
        deseaseThread.start();
    }

    /**
     * Destroys the disease, removing it from the affected animal.
     */
    private void destroyDesease() {
        if (this.animal != null) {
            this.animal.setIsSick(false);
            this.animal.removeDesease();
        }
    }


    public String getName() {
        return name;
    }
    /**
     * Removes the disease from the creature's list of diseases.
     * @param creature The creature to remove the disease from.
     */ 
    public void remove(Creature creature) {
        if (this.canBeTreatedWithMedecine== true&& !isTreated) {
                isTreated = true;
                deseaseThread.interrupt();
                System.out.println(this.animal.getName() + " n'es plus malade !"); 
        } else {
            System.err.println("L'animal " + this.animal.getName() + " a une maladie incurable...");
        }
    }


    /**
     * Gets the damage caused by the disease.
     * @return The damage caused by the disease.
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Gets the severity level of the disease.
     * @return The severity level of the disease.
     */
    public int getSeverity() {
        return severity;
    }

    /**
     * Gets the animal affected by the disease.
     * @return The animal affected by the disease.
     */
    public Creature getAnimal() {
        return animal;
    }

    /**
     * Sets the name of the disease.
     * @param name The new name of the disease.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the damage caused by the disease.
     * @param damage The new damage caused by the disease.
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Sets the severity level of the disease.
     * @param severity The new severity level of the disease.
     */
    public void setSeverity(int severity) {
        this.severity = severity;
    }

    /**
     * Sets the animal affected by the disease.
     * @param animal The new animal affected by the disease.
     */
    public void setAnimal(Creature animal) {
        this.animal = animal;
    }

    /**
     * Gets the time duration of the disease.
     * @return The time duration of the disease.
     */
    public int getTime() {
        return time;
    }

    /**
     * Sets the time duration of the disease.
     * @param time The new time duration of the disease.
     */
    public void setTime(int time) {
        this.time = time;
    }

}
