package br.com.pfood.filter;



import br.com.pfood.mb.imp.UsuarioLogadoMB;
import br.com.pfood.model.Usuario;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

public class Autenticacao implements PhaseListener {
    
    @Inject 
    private UsuarioLogadoMB usuarioLogadoMB;
    
	@Override
	public void afterPhase(PhaseEvent event) {
		
		FacesContext facesContext = event.getFacesContext();
		String currentPage = facesContext.getViewRoot().getViewId();
		 
//		boolean isLogin = (currentPage.lastIndexOf("login") > -1);
//		
//		Usuario user = usuarioLogadoMB.getUsuario();
//	
//                if (!isLogin && user == null) {
//			NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
//			nh.handleNavigation(facesContext, null, "/pages/default/login.jsf");
//		
//		} 

	
	}

	@Override
	public void beforePhase(PhaseEvent event) {	

	}

	@Override
	public PhaseId getPhaseId() {
		
		return PhaseId.RESTORE_VIEW;
	}

}
