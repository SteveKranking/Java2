class Gorilla extends Mammal{

    public void throwing(){
        setEnergy(getEnergy()-5) ;
        System.out.println("The gorrila threw something and now has " + getEnergy() + "energy");
    }
    public void eatBanana(){
        setEnergy(getEnergy()+10);
        System.out.println("The gorrila ate a bannana and now has " + getEnergy() + "energy");
    }
    public void climb(){
        setEnergy(getEnergy()-10);
        System.out.println("The climbed a rock and now has " + getEnergy() + "energy");
    }
}