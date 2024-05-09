import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Menu {
	
	Scanner sc = new Scanner(System.in);
	int opcao;
	
	private List<Pokemon> meusPokemons = new ArrayList<>();
	private List<Pokemon> todosPokemons = new ArrayList<>();
	
	public Menu(List<Pokemon> meusPokemons, List<Pokemon> todosPokemons) {
		this.meusPokemons.addAll(meusPokemons);
		this.todosPokemons.addAll(todosPokemons);
	}
	
	public void start() {
		
		menuPrincipal();
		
//		System.out.println("MEUS POKEMONS");
//		meusPokemons.forEach(System.out::println);
//		
//		System.out.println();
//		
//		System.out.println("TODOS POKEMONS");
//		todosPokemons.forEach(System.out::println);
	}
	
	private void menuPrincipal() {
		
//		meusPokemons.forEach(System.out::println);
//		todosPokemons.forEach(System.out::println);
		System.out.println(" ____       _            _           \r\n"
				+ "|  _ \\ ___ | | _____  __| | _____  __\r\n"
				+ "| |_) / _ \\| |/ / _ \\/ _` |/ _ \\ \\/ /\r\n"
				+ "|  __/ (_) |   <  __/ (_| |  __/>  < \r\n"
				+ "|_|   \\___/|_|\\_\\___|\\__,_|\\___/_/\\_\\");
		
		System.out.println();
		System.out.println("1 - Listar meus pokemons");
		System.out.println("2 - Adicionar um pokemon");
		System.out.println("3 - Remover um pokemon");
		System.out.println();

		System.out.print("Selecione uma opção: ");
		opcao = sc.nextInt();
		
		switch(opcao) {
			case 1:
				listarMeusPokemons();
				break;
			case 2:
				adicionarPokemon();
				break;
			case 3:
				removerPokemon();
				break;
		}
		
	}
	
	private void listarMeusPokemons() {
		System.out.println();
		meusPokemons.forEach(System.out::println);
		System.out.println();
		
		System.out.print("Digite 0 para voltar ou o id do pokemon para visualizar: ");
		opcao = sc.nextInt();
		
		Optional<Pokemon> pokemonOpt = meusPokemons.stream().filter(pokemon -> pokemon.id == opcao).findFirst();
		
		if(pokemonOpt.isEmpty()) {
			System.out.println("Pokemon com o id: " + opcao + " não existe.");
			menuPrincipal();
		}else {
			interagirComPokemon(pokemonOpt.get());
		}
		
	}
	
	public void interagirComPokemon(Pokemon pokemon) {
		System.out.println("POKEMON SELECIONADO: " + pokemon.getNome());
		
		System.out.println(pokemon);
		
	}
	
	private void adicionarPokemon(){
		System.out.println();
		System.out.println("TODOS OS POKEMONS");
		todosPokemons.forEach(System.out::println);
		System.out.println();
		
		System.out.print("Digite 0 para voltar ou o id do pokemon para adicionar ao seu deck: ");
		opcao = sc.nextInt();
		
		if(opcao != 0) {
			Optional<Pokemon> pokemonOpt = todosPokemons.stream().filter(pokemon -> pokemon.id == opcao).findFirst();
			
			if(pokemonOpt.isEmpty()) {
				System.out.println("Pokemon com o id: " + opcao + " não existe.");
				menuPrincipal();
			}
			
			Optional<Pokemon> pokemonNoMeuDeck = meusPokemons.stream().filter(pokemon -> pokemon.equals(pokemonOpt.get())).findFirst();
			
			if(pokemonNoMeuDeck.isEmpty()) {
				meusPokemons.add(pokemonOpt.get());
				System.out.println("Parabéns! \nPokemon " + pokemonOpt.get().nome + " adicionado ao seu deck.");
				menuPrincipal();
			}else {
				System.out.println("Pokemon " + pokemonOpt.get().nome + " já existe no seu deck.");
				menuPrincipal();
			}
		}else {
			menuPrincipal();
		}
		
	}
	
	private void removerPokemon() {
		System.out.println();
		System.out.println("SEUS POKEMONS");
		meusPokemons.forEach(System.out::println);
		System.out.println();
		
		System.out.print("Digite 0 para voltar ou o id do pokemon para removê-lo do seu deck: ");
		opcao = sc.nextInt();
		
		Optional<Pokemon> pokemonRemover = meusPokemons.stream().filter(pokemon -> pokemon.id == opcao).findFirst();
		
		if(pokemonRemover.isEmpty()) {
			System.out.println("Pokemon com o id: " + opcao + " não existe.");
			menuPrincipal();
		}else {
			meusPokemons.remove(pokemonRemover.get());
			System.out.println("Pokemon com o id: " + opcao + " removido com sucesso.");
			menuPrincipal();
		}
	}
	
}
