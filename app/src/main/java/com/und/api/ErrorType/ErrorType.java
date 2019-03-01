package bds.com.bds.api.ErrorType;

/**
 * Created by hungle on 01/03/2019.
 */

public class ErrorType {
    public static final int Success = 0;
    public static final int Undefined = 1;
    public static final int NotFound = 2;
    public static final int ModelInvalid = 3;
    public static final int NoEntity = 4;
    public static final int UserIsExists = 5;
    public static final int InvalidUser = 6;
    public static final int InvalidInvitedCode = 7;
    public static final int InvalidRequest = 8;
    public static final int InvalidToken = 9;
    public static final int InvalidPassword = 10;
    public static final int EmailIsExists = 11;

    int value;
    String description;

    public ErrorType(int code, String description)
    {
        this.value = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }

    public static ErrorType parseType(int code)
    {
        switch (code)
        {
            case Success:
                return new ErrorType(code, "Success");
            case Undefined:
                return new ErrorType(code, "Lỗi không xác định");
            case NotFound:
                return new ErrorType(code, "Không tìm thấy");
            case ModelInvalid:
                return new ErrorType(code, "Dữ liệu không hợp lệ");
            case NoEntity:
                return new ErrorType(code, "Không có giá trị");
            case UserIsExists:
                return new ErrorType(code, "Số điện thoại đã được sử dụng");
            case InvalidUser:
                return new ErrorType(code, "User không đúng");
            case InvalidInvitedCode:
                return new ErrorType(code, "Mã giới thiệu không đúng");
            case InvalidRequest:
                return new ErrorType(code, "Invalid Request");
            case InvalidToken:
                return new ErrorType(code, "Invalid Token");
            case InvalidPassword:
                return new ErrorType(code, "Mật khẩu không đúng");
            case EmailIsExists:
                return new ErrorType(code, "Email đã được sử dụng");
            default:
                return new ErrorType(-1, "Lỗi không xác định");
        }
    }
}
