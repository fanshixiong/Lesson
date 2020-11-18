Public Class frmTest
    Dim Btns As List(Of clsBtn)

    Private Sub btnCreate_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnCreate.Click
        Dim n As Integer = txtN.Text
        Btns = New List(Of clsBtn)
        For i = 0 To n - 1
            Btns.Add(New clsBtn(100 + i * 60, 100, i))
        Next
        For i = 0 To Btns.Count - 1
            Controls.Add(Btns(i).Btn)
        Next
    End Sub

End Class
