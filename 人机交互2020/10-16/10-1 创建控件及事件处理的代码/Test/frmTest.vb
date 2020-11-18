Public Class frmTest
    Dim WithEvents Btn As System.Windows.Forms.Button

    Private Sub btnCreate_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnCreate.Click

        Btn = New System.Windows.Forms.Button()

        Btn.Location = New System.Drawing.Point(100, 100)
        Btn.Name = "myBtn"
        Btn.Size = New System.Drawing.Size(60, 40)
        Btn.Text = "myBtn"

        Controls.Add(Btn)

    End Sub

    Private Sub Btn_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles Btn.Click
        Dim it As Button = sender
        MsgBox(it.Name)
        'MsgBox(Btn.Name)
    End Sub
End Class
