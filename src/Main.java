import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Pokemon pokemon1 = new Pokemon("Pikachu", "Um Pokémon Elétrico amarelo e fofinho.", "Elétrico", "Terra", "Pichu -> Pikachu -> Raichu");
        Pokemon pokemon2 = new Pokemon("Bulbasaur", "Um Pokémon do tipo Planta e Veneno.", "Planta/Veneno", "Fogo, Gelo, Psíquico", "Bulbasaur -> Ivysaur -> Venusaur");
        Pokemon pokemon3 = new Pokemon("Charmander", "Um pequeno Pokémon do tipo Fogo.", "Fogo", "Água, Terra, Rocha", "Charmander -> Charmeleon -> Charizard");
        Pokemon pokemon4 = new Pokemon("Squirtle", "Um Pokémon do tipo Água com casca.", "Água", "Planta, Elétrico", "Squirtle -> Wartortle -> Blastoise");
        Pokemon pokemon5 = new Pokemon("Eevee", "Um Pokémon com incríveis capacidades de evolução.", "Normal", "Lutador", "Eevee -> Vaporeon/Jolteon/Flareon/Espeon/Umbreon/Glaceon/Leafeon/Sylveon");
		
		Menu menu = new Menu(Arrays.asList(pokemon1, pokemon2, pokemon3, pokemon5), Arrays.asList(pokemon1, pokemon2, pokemon3, pokemon4, pokemon5));
		
		menu.start();

	}

}
