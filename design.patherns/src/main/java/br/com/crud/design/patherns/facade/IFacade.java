package br.com.crud.design.patherns.facade;

import java.util.List;

public interface IFacade {
	public abstract Object save(Object obj);
	public abstract List<Object> list();
}
