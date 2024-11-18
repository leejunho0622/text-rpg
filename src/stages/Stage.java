package stages;

import interfaces.IOManager;

public abstract class Stage implements IOManager{
	public abstract void init();
	public abstract void start();
}