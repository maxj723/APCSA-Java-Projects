package quiz;

class Fight {

  private Wizard enemy;
  private Wizard you;

  public Fight(Wizard y) {
    this.enemy = new Wizard();
    this.you = y;
  }

  public Fight(Wizard y, Wizard e) {
    this.enemy = e;
    this.you = y;
  }

  public void start() {
    int sCount = 1;
    while (you.getHealth() > 0 && enemy.getHealth() > 0) {
      if (sCount % you.getSpeed() == 0 && sCount % enemy.getSpeed() == 0) {
        if (you.getSpeed() < enemy.getSpeed()) {
          enemy.setHealth(enemy.getHealth() - you.getAttackDamage());
        System.out.println(you.getName() + " used " + you.getAttackName() + ". " + enemy.getName() + " now has " + enemy.getHealth() + " Health.");
          if (enemy.getHealth() > 0) {
            you.setHealth(you.getHealth() - enemy.getAttackDamage());
        System.out.println(enemy.getName() + " used " + enemy.getAttackName() + ". " + you.getName() + " now has " + you.getHealth() + " Health");
          }
        } else {
          you.setHealth(you.getHealth() - enemy.getAttackDamage());
        System.out.println(enemy.getName() + " used " + enemy.getAttackName() + ". " + you.getName() + " now has " + you.getHealth() + " Health");
          if (you.getHealth() > 0) {
            enemy.setHealth(enemy.getHealth() - you.getAttackDamage());
        System.out.println(you.getName() + " used " + you.getAttackName() + ". " + enemy.getName() + " now has " + enemy.getHealth() + " Health.");
          }
        }
      } else if (sCount % you.getSpeed() == 0) {
        enemy.setHealth(enemy.getHealth() - you.getAttackDamage());
        System.out.println(you.getName() + " used " + you.getAttackName() + ". " + enemy.getName() + " now has " + enemy.getHealth() + " Health.");
      } else if (sCount % enemy.getSpeed() == 0) {
        you.setHealth(you.getHealth() - enemy.getAttackDamage());
        System.out.println(enemy.getName() + " used " + enemy.getAttackName() + ". " + you.getName() + " now has " + you.getHealth() + " Health");
      }
      sCount++;
    }
    if (you.getHealth() <= 0 && enemy.getHealth() <= 0) {
      System.out.println("Both " + you.getName() + " and " + enemy.getName() + " died!!");
    } else if (enemy.getHealth() <= 0) {
      System.out.println(you.getName() + " won the Fight!");
      System.out.println(enemy.getName() + " dies from " + you.getAttackName());
    } else {
      System.out.println(enemy.getName() + " won the Fight!");
      System.out.println(you.getName() + " dies from " + enemy.getAttackName());
    }
      
    
  }


  
}