#Pokemon TCG: Basic Elements
This repository contains the basic elements of a Pokemon TCG clone, these include
the cards, the pokemon, energies, attacks and a representation of the player (as a trainer).

There are 5 types of entities represented as interfaces: ITrainer represents the player
of the game and contains several methods that allow different interactions between
the cards and the pokemon of the player. IPokemon defines methods for interactions between pokemon,
including attacking and receiving attacks. IAttack defines how attacks work, including the interaction between them and energies.
IEnergy contains methods for the interactions between pokemon and energies. Finally, 
the ICard interface has common methods for both IPokemon and IEnergy, considering both entities can be used as cards.