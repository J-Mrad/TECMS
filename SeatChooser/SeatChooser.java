package SeatChooser;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.Calendar;
import java.util.LinkedList;

import Interface.Popups;
import Interface.UsageLog;
import Listers.ticketDisplay;
import People.Customer;
import Schedules.Movies;
import Schedules.ShowRooms;
import Schedules.Utils;

public class SeatChooser extends Canvas implements Runnable {
	public LinkedList<Seat> seats = new LinkedList<Seat>();

	private static final long serialVersionUID = -8506389613978299898L;
	public static final Dimension DIMENSION = new Dimension(1280, 720);
	public Thread thread;
	private boolean running = false;
	private Handler handler;
	MouseInput mouseInput;
	public Window window;
	
	private Customer C = null;
	private Movies M = null;
	private ShowRooms S = null;
	private Calendar cal = null;
	
	public SeatChooser(Customer C, Movies M, ShowRooms showRoom, Calendar cal) {
		
		this.C = C;
		this.M = M;
		this.S = showRoom;
		this.cal = cal;
		
		handler = new Handler(showRoom);
		window = new Window(DIMENSION, "Please Choose A Seat", this);
		mouseInput = new MouseInput(handler, this);
		this.addMouseListener(mouseInput);
		

	}

	public void finishOperation() {
		if(C != null && M != null && S != null && cal != null) {
			C.moviesWatchedCount += seats.size();
			C.moneyCustomerPaidSoFar += S.getPrice() * seats.size();
			Customer.totalMoviesProfit += S.getPrice() * seats.size();
			C.setLoyaltyPoints( (int)( C.getLoyaltyPoints() + ( S.getPrice()/1000 + Utils.clamp(C.moviesWatchedCount, 1, 20) ) ) );
			
			for(Seat tmp : seats) {
				new ticketDisplay(C,M,S,cal,tmp);
				
			}
			
			window.frame.dispatchEvent(new WindowEvent(window.frame, WindowEvent.WINDOW_CLOSING));

		}
		else {
			UsageLog.add("Sale aborted");
			Popups.show("WARNING: One or more of the entered values does not exist!");
		}
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {			
			running = false;
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		@SuppressWarnings("unused")
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				delta--;
			}
			if (running)
				render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				// System.out.println("FPS : " + frames);
				frames = 0;
			}
		}
	}

	public void update() {
		handler.update();
	}

	public void render() {
		BufferStrategy bStrategy = this.getBufferStrategy();
		if (bStrategy == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics graphics = bStrategy.getDrawGraphics();

		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, DIMENSION.width, DIMENSION.height);

		if (running)
			handler.render(graphics);

		graphics.drawRect(1280 - 250, 720 - 130, 200, 70);
		Font font = new Font("Segoe UI", Font.PLAIN, 40);
		graphics.setFont(font);
		graphics.drawString("Done", 1280 - 195, 720 - 85);
		graphics.dispose();
		bStrategy.show();
	}
	
}
