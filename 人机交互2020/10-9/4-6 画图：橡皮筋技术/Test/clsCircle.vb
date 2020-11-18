Public Class clsCircle
    Inherits clsElem


    Private cp As Point, r As Single

    Public Sub New(ByVal cp As Point, ByVal r As Single)
        Me.cp = cp : Me.r = r
    End Sub

    Public Overrides Sub Draw(ByVal g As System.Drawing.Graphics)
        g.DrawEllipse(Pens.Blue, cp.X - r, cp.Y - r, 2 * r, 2 * r)
    End Sub
    Public Overloads Overrides Sub Draw(ByVal g As System.Drawing.Graphics, ByVal pen As System.Drawing.Pen)
        g.DrawEllipse(pen, cp.X - r, cp.Y - r, 2 * r, 2 * r)
    End Sub
    Overrides Function ToString() As String
        Dim s As String = "Circle ("
        s = s & cp.X & "," & cp.Y & "), " & r
        Return s
    End Function

End Class
