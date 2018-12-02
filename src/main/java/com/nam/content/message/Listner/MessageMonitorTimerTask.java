package com.nam.content.message.Listner;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import com.nam.content.message.reader.ContentReader;

public class MessageMonitorTimerTask extends TimerTask {
	public static String MESSAGE_FILE_PATH = "C:\\tmp";

	@Override
	public void run() {
		final File folder = new File(MESSAGE_FILE_PATH);
		lookupForIncomingMessageFiles(folder);

	}

	private void lookupForIncomingMessageFiles(final File folder) {

		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				lookupForIncomingMessageFiles(fileEntry);
			} else {
				System.out.println(fileEntry.getName());
				ContentReader contentReader = new ContentReader();
				try {
					contentReader.processFile(fileEntry);
				} catch (Exception e) {
					// Log here
				}

			}
		}

	}

	public static void main(String args[]) {
		TimerTask timerTask = new MessageMonitorTimerTask();
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(timerTask, 0, 10 * 1000);
		System.out.println("TimerTask started");
		try {
			Thread.sleep(120000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// timer.cancel();
		// System.out.println("TimerTask cancelled");
		// try {
		// Thread.sleep(30000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
	}

}
