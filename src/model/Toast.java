package model;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;

public class Toast
{
	public Toast ( String appName, String msg ) throws AWTException
	{
		SystemTray tray = SystemTray.getSystemTray();
		Image image = Toolkit.getDefaultToolkit().getImage("tray.gif");
		TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
		tray.add(trayIcon);
		trayIcon.displayMessage( appName, msg, MessageType.INFO);
	}
}