package Zoo;

import Zoo.Animals.Creature;

public class Desease {
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
        animal.becomeSick(this);
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
    //fonction qui fait en sorte que la maladie agit sur l'animal
    //si l'animal est infecté par une maladie de severity 3 il va mourir dans tout les cas car incurable
    //si l'animal est infecté par une maladie de severity 2 il peut être traité avec un médicament
    //si l'animal est infecté par une maladie de severity 1 il va se soigner tout seul...
    //le temps diminue avec la sévérity...
    public void deseaseAct() {
        final int[] currentTime = {0};
        deseaseThread = new Thread(() -> {
            while (currentTime[0] != getTime() && !isTreated && !Thread.currentThread().isInterrupted()&& this.animal.getIndicatorHealth()!="Dead") {
                try {
                	if(this.severity!=3) {currentTime[0] += 1;}
                	getAnimal().becomeMoreSick();
                    Thread.sleep(1500 / severity);
                    System.out.println(animal.getName() + " est malade depuis " + currentTime[0] + " secondes");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            destroyDesease();
        });
        deseaseThread.start();
    }

    //fonction qui détruit une maladie (l'objet va s'auto-détruire par java automatiquement)
    private void destroyDesease() {
        if (this.animal != null) {
            this.animal.setIsSick(false);
            this.animal.removeDesease();
        }
    }


    public String getName() {
        return name;
    }
    //fonction qui enlève la maladie depuis la classe Creature 
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
