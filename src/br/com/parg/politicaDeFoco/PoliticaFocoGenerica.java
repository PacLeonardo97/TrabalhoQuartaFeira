package br.com.parg.politicaDeFoco;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.util.LinkedList;

public class PoliticaFocoGenerica  extends FocusTraversalPolicy {

  	  protected final java.util.List<Component> componentes = new LinkedList<>();
  	  private int focado = 0;

  	  @Override
  	  public Component getComponentAfter(Container focusCycleRoot, Component aComponent) {
  	    this.focado = (this.focado + 1) % this.componentes.size();

  	    return this.componentes.get(focado);
  	  }

  	  @Override
  	  public Component getComponentBefore(Container focusCycleRoot, Component aComponent) {
  	    this.focado = (this.componentes.size() + this.focado - 1) % this.componentes.size();

  	    return this.componentes.get(focado);
  	  }

  	  @Override
  	  public Component getDefaultComponent(Container focusCycleRoot) {
  	    return this.componentes.get(0);
  	  }

  	  @Override
  	  public Component getLastComponent(Container focusCycleRoot) {
  	    return this.componentes.get(this.componentes.size() - 1);
  	  }

  	  @Override
  	  public Component getFirstComponent(Container focusCycleRoot) {
  	    return this.componentes.get(0);
  	  }
}