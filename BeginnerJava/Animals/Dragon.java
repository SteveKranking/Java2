class Dragon extends Mammal{
    public Dragon(){
        setEnergy(getEnergy()+300);
    }
    

    public void attackTown(){
        setEnergy(getEnergy()-100) ;
        System.out.println("The Dragon attacked a town and now has " + getEnergy() + "energy");
    }
    public void eatHumans(){
        setEnergy(getEnergy()+25);
        System.out.println("The Dragon ate a human and now has " + getEnergy() + "energy");
    }

    public void fly(){
        setEnergy(getEnergy()-50);
        System.out.println("The Dragon flew and now has " + getEnergy() + "energy");
    }
}