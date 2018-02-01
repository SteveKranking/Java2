public class Pokemon implements InterPokemon {

    static int numPokemon = 0;
    public String name;
    public String type;
    public int health;

    public Pokemon(String nameParam, String typeParam, int healthParam) {
        InterPokemon.createPokemon();
    }

    public void attack() {
        InterPokemon.attackPokemon();
    }

    public void info() {
        InterPokemon.pokemonInfo();
    }

}