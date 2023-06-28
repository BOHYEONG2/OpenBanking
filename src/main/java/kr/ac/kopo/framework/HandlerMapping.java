package kr.ac.kopo.framework;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


/*
 * HandlerMapping 클래스는 기본 생성자와 파일 경로를 받는 생성자를 가지고 있습니다.
 *  기본 생성자는 하드코딩된 파일 경로(C:\\Users\\User\\eclipse-workspaceJSP\\MyBanking\\bean.properties)를 
 *  사용하여 bean.properties 파일에서 컨트롤러 클래스 정보를 읽어와 매핑합니다.
 *   파일 경로를 받는 생성자는 전달된 파일 경로를 사용하여 bean.properties 파일을 읽고 컨트롤러 클래스와 매핑합니다.

각 생성자에서는 Properties 객체를 사용하여 파일을 읽고, 
읽어온 컨트롤러 클래스 정보를 Class.forName()을 통해 클래스로 변환하고,
 해당 클래스의 기본 생성자를 얻어서 인스턴스를 생성합니다. 그리고 매핑된 URI와 컨트롤러 인스턴스를 mappings 맵에 저장합니다.

getController() 메서드는 주어진 URI에 해당하는 컨트롤러를 반환합니다.
 */
public class HandlerMapping {
	
	private Map<String, Controller> mappings;
	
//	public HandlerMapping() {   // 왜 이걸 생성자 안에 new한다 하셧지 >> 계속 초기화 
//		mappings = new HashMap<>(); 
//		Properties prop = new Properties();
//		
//		try {
//			InputStream is = new FileInputStream("C:\\Users\\User\\eclipse-workspaceJSP\\MyBanking\\bean.properties");  // 왼쪽 파일에 들어가면 properties있음 
//			prop.load(is); 
//	
//			Set<Object> keys = prop.keySet();
//			for(Object key : keys) {
//				System.out.println(key);
//				String className = prop.getProperty(key.toString());    // key가 오브젝트형으로 되어있고 property는 String형이니 toString
//				System.out.println(key + " : " + className); 
//				
//				Class<?> clz = Class.forName(className);
//				Constructor<?> constructor = clz.getConstructor();
//				
//			//	mappings.put(key, constructor.newInstance());  // 이건 오브젝트형인데 우린 컨트롤러 형으로 만들어서 에러 안나려면 명시적 형변환 해줘야함
//				mappings.put(key.toString(), (Controller)constructor.newInstance()); 
//		}
//		
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}

	
	public HandlerMapping(String propLoc) {
	      mappings = new HashMap<>();
	      Properties prop = new Properties();
	      
	      try {
	         InputStream is = new FileInputStream(propLoc);
	         prop.load(is);
	         
	         Set<Object> keys = prop.keySet();
	         for(Object key : keys) {
	            String className = prop.getProperty(key.toString());
	            System.out.println(key + " : " + className);
	            
	            Class<?> clz = Class.forName(className);
	            Constructor<?> constructor = clz.getConstructor();
	            
	            mappings.put(key.toString(),
	                  (Controller)constructor.newInstance());
	         }
	         
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	      
	}

	public Controller getController(String uri) {
		return mappings.get(uri);		
	}
		
		
}
/*		
		public static void main(String[] args) throws Exception {
//			java.util.Random r = new java.util.Random();
//			System.out.println(r.nextInt());
			
			Class<?> clz = Class.forName("java.util.Random");
			// 어떤값을 받을지 모르니 모든걸 받겠다는 뜻으로 ? 를 썼음 그걸 와일드카드라고 부름 ***와일드카드 타입은 모든 타입을 읽는다***
			//1.클래스 내용을 가져오고 
			
		    //Object obj = clz.newInstance();  Constructor은 생성자 클래스
			Constructor<?> constructor = clz.getConstructor();
			//2.생성자를 만들고
			Object obj = constructor.newInstance();
			//3. 인스턴스 객체를 만든다
			
			System.out.println("난수 : " + ((java.util.Random)obj).nextInt());
			
	}

}
*/
