public class Pokedex extends MakeEmAll{

    public Pokedex(){

    }
    public void pokemonInfo(Pokemon pokemon){
        int health = pokemon.health;
        String name = pokemon.name;
        String type = pokemon.type;
        System.out.println("Pokemon " + name + ": Type- " + type + " Health- " + health);
    }
}