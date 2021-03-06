package rules;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import core.Card;
import core.Effect;
import core.GameState;
import core.GameStateException;
import core.Player;
import core.Resource;
import core.Slot;
import presenter.IPlayerNotifier;
import presenter.IPlayerNotifier.IPlayerNotifierListener;

public class JanKenPonTextPresenter implements IPlayerNotifier {
	public GameState state;
	IPlayerNotifierListener listener;
	private static Scanner input = new Scanner(System.in);

	@Override
	public void resourceAmountChanged(Resource arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void slotAdded(Slot arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void turnStateChanged(String newState) {
		System.out.println("Intercepted state:" + newState);
		if(newState.equals(JanKenPonGameRules.JanKenPonState.STATE_CHOOSE_TYPE.toString())) {
			try {
				chooseMove();
			} catch(Exception e) {
				System.out.println(e.getMessage());
                e.printStackTrace();
			}
		} else if(newState.startsWith(JanKenPonGameRules.JanKenPonState.STATE_PLAYER_1_WON.toString())) {
			System.out.println("You won!");
			listener.playerQuitGame(this);
		} else {
			System.out.println("Oh no, the AI won!");
			listener.playerQuitGame(this);
		}
	}
	
	private void chooseMove() throws Exception {
		System.out.println("Choose your move:");
		List<Effect> moves = state.getAllGlobalEffects();
		for(int i=0;i<moves.size();i++) {
			System.out.println(i + ") " + moves.get(i).getEffectName());
		}
		int choice = -1;
		do {
			try {
				choice = input.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Invalid choice.");
			}
		}
		while(choice > moves.size() || choice < 0);
		if(!listener.playerWantsToUseCardEffect(this, moves.get(choice).getID())) {
			throw new Exception("Presenter errorrrrrr");
		}
	}

	@Override
	public void globalEffectAdded(Effect e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subscribeListener(IPlayerNotifierListener listener) {
		this.listener = listener;
	}

	@Override
	public void cardDestroyed(Card c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void effectTriggered(Effect e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cardAddedToSlot(Card c, Slot s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cardMovedToSlot(Card c, Slot s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cardAddedToCard(Card host, Card parasite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cardAttachedToCard(Card host, Card parasite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resourceCreated(Resource r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playerQuitGame(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playerSentMessage(Player player, String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disconnectedFromGame(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void effectAnnounced(Effect e) {
		// TODO Auto-generated method stub
		
	}

}
