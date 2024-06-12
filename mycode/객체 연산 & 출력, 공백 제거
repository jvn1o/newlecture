import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
       
        // String fileName = "photo.jpg";
        // int endIndex = fileName.indexOf(".");
        // String name = fileName.substring(0,endIndex); // 문자열 지정하여 출력하기
        // // String name = fileName.substring(endIndex+1,fileName.length())  ->  fileName의 길이만큼을 고정적으로 가져와서 수정이 필요없다.

        // String fullName = name
        //                     .concat(".jpg") // 문자열 더하기, 즉 개체의 더하기라서 '+(플러스는 산술의 더하기)'는 사용 불가능
        //                     .concat("Hi")
        //                     .substring(0);

        // System.out.println(fullName);




        String content = """
                <section>
                    <h1>긴급속보</h1>
                    <div>
                        동해상에 오징어가 찾아왔어요~~
                    </div>
                </section>
                """;
        int startIndex = content.indexOf("<div>");
        int endIndex = content.indexOf("</div>");
        String result = content.substring(startIndex + "<div>".length(),endIndex);
        System.out.println(result.trim()); // trim은 영역을 차지하는 공백을 지워주는 역할을 한다.
    }
}
