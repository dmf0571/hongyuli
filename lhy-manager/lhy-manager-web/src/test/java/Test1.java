import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * @创建人 李弘昱
 * @创建时间 2018/6/30
 * @描述
 */
public class Test1 {
    @Test
    public void testFtp() throws Exception {
        //1、连接ftp服务器
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("47.96.127.75", 21);
        //2、登录ftp服务器
        ftpClient.login("hongyuli", "ll278811155");
        //3、读取本地文件
        FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\ibm\\Pictures\\Camera Roll\\1.png"));
        //4、上传文件
        //1）指定上传目录
        ftpClient.changeWorkingDirectory("/home/hongyuli/www/images");
        //2）指定文件类型
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
        //第一个参数：文件在远程服务器的名称
        //第二个参数：文件流
        ftpClient.storeFile("1.png", inputStream);
        //5、退出登录
        ftpClient.logout();
    }

}
