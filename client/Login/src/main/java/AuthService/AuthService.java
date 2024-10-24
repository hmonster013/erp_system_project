/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuthService;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Khoahihi79
 */
public class AuthService {
    
    private Map<String, String> users = new HashMap<>();

    public AuthService() {
        // Khởi tạo một số tài khoản với phân hệ tương ứng
        users.put("admin_kho", "quanlykho:123456"); // tài khoản cho phân hệ quản lý kho
        users.put("admin_sanxuat", "quanlysanxuat:123456"); // tài khoản cho phân hệ quản lý sản xuất
    }

    // Hàm login kiểm tra username và password
    public boolean login(String username, String password) {
        if (users.containsKey(username)) {
            // Lấy chuỗi chứa thông tin phân hệ và mật khẩu
            String[] parts = users.get(username).split(":");
            String correctPassword = parts[1];

            // Kiểm tra mật khẩu
            return password.equals(correctPassword);
        }
        return false; // Trả về false nếu không tồn tại tài khoản
    }

    // Hàm trả về phân hệ mà tài khoản đăng nhập thuộc về
    public String getSubsystem(String username) {
        if (users.containsKey(username)) {
            // Trả về phân hệ (được lưu ở phần trước dấu :)
            return users.get(username).split(":")[0];
        }
        return null;
    }
    
}
