public interface InterPokemon {

    default Pokmeon createPokemon(String name, String type, int health) {

        Pokemon pokemon = new Pokemon(name, type, health);
        return pokemon;

    }

    default int attackPokemon(Pokemon pokemon) {

        pokemon.health-= 10;
        String atk = pokemon.name + " was attacked! Health is now " + pokemon.health + "hp.";
        return atk;

    }

    default String pokemonInfo(Pokemon pokemon) {

    String info = pokemon.name + " " + pokemon.type + " " + pokemon.health;
    return String info;

    }
}