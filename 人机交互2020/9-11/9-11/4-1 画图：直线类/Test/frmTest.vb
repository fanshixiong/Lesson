Imports System.IO

Public Class frmTest
    Dim sp As Point

    Private Sub picCanvas_MouseDown(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles picCanvas.MouseDown
        sp = e.Location
    End Sub
    Private Sub picCanvas_MouseUp(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles picCanvas.MouseUp
        Dim ep As Point = e.Location
        Dim line As New clsLine(sp, ep)
        Dim g As Graphics = picCanvas.CreateGraphics()
        line.Draw(g)
    End Sub
End Class
