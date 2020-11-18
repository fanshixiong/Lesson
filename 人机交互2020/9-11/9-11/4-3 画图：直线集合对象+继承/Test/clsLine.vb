Public Class clsLine
    Inherits clsElem

    Private sp As Point, ep As Point

    Public Sub New(ByVal sp As Point, ByVal ep As Point)
        Me.sp = sp : Me.ep = ep
    End Sub
    Public Overrides Sub Draw(ByVal g As System.Drawing.Graphics)
        g.DrawLine(Pens.Blue, sp, ep)
    End Sub
    Overrides Function ToString() As String
        Dim s As String = "Line ("
        s = s & sp.X & "," & sp.Y & ") - ("
        s = s & sp.X & "," & sp.Y & ")"
        Return s
    End Function

End Class
