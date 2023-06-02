package java85_mvc_jtextarea.controller;

import java85_mvc_jtextarea.model.TimKiemModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TimKiemListener {
    public TextArea txtVanBan;
    public TextField txtTuKhoa;
    public Label txtKetQua;
    TimKiemModel tk = new TimKiemModel();
    public void timKiemListener(ActionEvent actionEvent) {
        String vanBan = txtVanBan.getText();
        String tuKhoa = txtTuKhoa.getText();
        String ketQua;

        ketQua = tk.timKiem(vanBan, tuKhoa);
        txtKetQua.setText(ketQua);
    }
}
