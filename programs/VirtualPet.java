public class VirtualPet {
  private String name;
  private int energyLevel = 0;
  private int happinessLevel = 0;
  private int weightGrams = 5;
  private int ageYears = 0;
  private int ageMonths = 0;

  public VirtualPet(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return String.format("%s's information:\nEnergy: %d\nHappiness: %d\nWeight = %dg\nage: %d months and %d years", name, energyLevel, happinessLevel, weightGrams, ageMonths, ageYears);
  }

  public void feed() {
    energyLevel = Math.min(energyLevel + 1, 10);
    weightGrams += 1;
  }

  public int getEnergyLevel() {
    return energyLevel;
  }

  public int getHappinessLevel() {
    return happinessLevel;
  }

  private void setHappinessLevel(int happiness) {
    if (happiness < 0) {
      happinessLevel = 0;
    } else if (happiness > 10) {
      happinessLevel = 10;
    } else {
      happinessLevel = happiness;
    }
  }

  private void setEnergyLevel(int energy) {
    if (energy < 0) {
      energyLevel = 0;
    } else if (energy > 10) {
      energyLevel = 10;
    } else {
      energyLevel = energy;
    }
  }

  private void setWeight(int newWeight) {
    if (newWeight < 5) {
      weightGrams = 5;
    } else {
      weightGrams = newWeight;
    }
  }

  private void makeOlder(int monthsOlder) {
    ageMonths += monthsOlder;
    if (ageMonths >= 12) {
      ageYears += (ageMonths / 12);
      ageMonths = ageMonths % 12;
    }
  }

  public void play() {
    setHappinessLevel(happinessLevel + 1);
    setWeight(weightGrams - 1);
  }

  public void updateStatus() {
    setHappinessLevel(happinessLevel - 1);
    setEnergyLevel(energyLevel - 1);
    makeOlder(1);
  }
}

class Food {
  private String name;
  private int energy;
  private int happiness;
  private int weight;

  public Food(String name, int energy, int happiness, int weight) {
    this.name = name;
    this.energy = energy;
    this.happiness = happiness;
    this.weight = weight;
  }

  public int getWeight() {
    return weight;
  }

  public int getHappiness() {
    return happiness;
  }

  public int getEnergy() {
    return energy;
  }

  public String getName() {
    return name;
  }
}

class Game {
  private String name;
  private int happiness;
  private int weight;

  public Game(String name, int happinessIncr, int weightDecr) {
    this.name = name;
    happiness = happinessIncr;
    weight = weightDecr;
  }

  public String getName() {
    return name;
  }

  public int getHappinessIncrease() {
    return happiness;
  }

  public int getWeightDecrease() {
    return weight;
  }

  public boolean isWinner() {
    return Math.random() > .5;
  }
}