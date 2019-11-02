import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import su.litvak.chromecast.api.v2.ChromeCast;
import su.litvak.chromecast.api.v2.ChromeCasts;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ChromeCasts.startDiscovery();
		ChromeCast chromecast = null;
		if(ChromeCasts.get().size()>0)
			chromecast = ChromeCasts.get().get(0);
		
		
		System.out.println(chromecast.getStatus().toString());
		
	}

}
