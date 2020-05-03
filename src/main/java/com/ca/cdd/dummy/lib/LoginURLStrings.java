package com.ca.cdd.dummy.lib;

public class LoginURLStrings extends Library implements InterfaceClass {
   // test
  private static String NAME = "AnonymousClass";
     
  InterfaceClass anonymusMethos = new InterfaceClass() {
        @Override
        public Integer useAbstractInInterface() {
            return null;
        }

        @Override
        public String interfaceStingMethod() {
            return "Returned From Anonymous Class ";
        }
    };

    @Override
    public Integer useAbstractInInterface() {
        return anonymusMethos.useAbstractInInterface();
    }

    @Override
    public String interfaceStingMethod() {
        return anonymusMethos.interfaceStingMethod();
    }
    
    @Override
    public String getName() {
        return NAME;
    }
	
	public String getGoogleURL() {
        return "/login/google";
    }
	public String getLinkedInURL() {
        return "/login/linkedin";
    }
			
}
